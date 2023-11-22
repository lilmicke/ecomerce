package com.example.wazitoecomerce.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.wazitoecomerce.models.Product
import com.example.wazitoecomerce.navigation.LOGIN_URL
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class ProductViewModel( var navController: NavHostController, var context: Context) {
    var authViewModel:AuthViewModel
    var progress:ProgressDialog
    init {
        authViewModel=AuthViewModel(navController,context)
        if (!authViewModel.isloggedIn()){
            navController.navigate(LOGIN_URL)
        }
        progress=ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }
    fun uploadProduct(name:String,quantity:String,price:String,filepath: Uri){
        val productId=System.currentTimeMillis().toString()
        val storageRef= FirebaseStorage.getInstance(
        ).getReference()
            .child("Products/$productId")
        progress.show()
        storageRef.putFile(filepath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
//                save to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var product = Product(name,quantity,price,imageUrl,productId)
                    var databaseRef =FirebaseDatabase.getInstance().getReference()
                        .child("products/$productId")
                    databaseRef.setValue(product).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }else{
                Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
            }
        }
        fun allProducts(product:MutableState<Product>,
                        products:SnapshotStateList<Product>):SnapshotStateList<Product>{
            progress.show()
            var ref= FirebaseDatabase.getInstance().getReference().child("products")
            ref.addValueEventListener(object:ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    products.clear()
                    for (snap in snapshot.children){
                        var retrievedProduct =snap.getValue(Product::class.java)
                        product.value =retrievedProduct!!
                        products.add(retrievedProduct)
                    }
                    progress.dismiss()
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
                }
            })
            return products
        }
        fun deleteProduct(productId:String){
            var ref =FirebaseDatabase.getInstance().getReference().child("products/$productId")
            ref.removeValue()
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        }
    }
}