@file:Suppress("UNREACHABLE_CODE")

package com.example.easymart

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.easymart.model.Product
import kotlinx.android.synthetic.main.activity_items.*
import kotlinx.android.synthetic.main.app_bar_main.*

class ItemsAct : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)


        val products = arrayListOf<Product>()

        products.add(
            Product(
                title = "Rice",
                photoUrl= "https://inrdeals.sgp1.cdn.digitaloceanspaces.com/production/172369/731435-200x200.jpg",
                price = "₹100/kg"
            )
        )
        products.add(
            Product(
                title = "Chips",
                photoUrl = "https://www.kroger.com/product/images/medium/front/0002840019914",
                price = "₹40"
            )
        )
        products.add(
            Product(
                title = "Flour",
                photoUrl = "https://osiamart.com/image/cache/catalog/ProductImage/Aashirvaad%20Atta-10kg-200x200.jpg",
                price = "₹40/kg"
            )
        )
        products.add(
            Product(
                title = "Sugar",
                photoUrl = "https://munafamart.co.in/wp-content/uploads/2020/04/Dhampur-Sugar-White-1Kg.jpg",
                price = "₹50/kg"
            )
        )
        products.add(
            Product(
                title = "Brown Rice",
                photoUrl = "https://buybuycart.com/wp-content/uploads/2020/05/Daawat-Brown-Basmati-Rice-1kg-Jar-buybuucart-5.jpg",
                price = "₹130/kg"
            )
        )
        products.add(
            Product(
                title = "Refined Oil",
                photoUrl = "https://cpimg.tistatic.com/05405400/s/4/Fortune-Sunlite-Refined-Oil.jpg",
                price = "₹210/ltr"
            )
        )
        products.add(
            Product(
                title = "Olive Oil",
                photoUrl = "https://d1s2zprapij148.cloudfront.net/image/cache/catalog/products/4422_1-200x200.jpg",
                price = "₹750/ltr"
            )
        )
        products.add(
            Product(
                title = "Water",
                photoUrl = "https://cpimg.tistatic.com/06204873/b/4/Bisleri-Water.jpg?tr=n-w200",
                price = "₹20"
            )
        )
        products.add(
            Product(
                title = "Butter",
                photoUrl = "https://thenishopping.com/image/cache/catalog/11amul/amul-butter-pasteurized-200x200.jpg",
                price = "₹250/500g"
            )
        )
        products.add(
            Product(
                title = "Salt",
                photoUrl = "https://osiamart.com/image/cache/catalog/products/50product/TATA%20SALT-1%20kg-200x200.jpg",
                price = "₹50/kg"
            )
        )
        products.add(
            Product(
                title = "Bread",
                photoUrl = "https://d1s2zprapij148.cloudfront.net/image/cache/catalog/products/529_1-200x200.jpg",
                price = "₹35"
            )
        )
        products.add(
            Product(
                title = "Egg",
                photoUrl = "https://kids.kiddle.co/images/thumb/1/1b/White_chicken_egg_square.jpg/200px-White_chicken_egg_square.jpg",
                price = "₹7"
            )
        )
        products.add(
            Product(
                title = "Brown Bread",
                photoUrl = "https://d1s2zprapij148.cloudfront.net/image/cache/catalog/products/527_2-200x200.jpg",
                price = "₹40"
            )
        )
        products.add(
            Product(
                title = "Curd",
                photoUrl = "https://www.elexweb.com/shopping/image/cache/catalog/Mother%20Dairy/mother-dairy-dahi-ultimate-rich-and-delicious-400gm-pack-200x200.jpg",
                price = "₹65/500g"
            )
        )

        recycler_view.apply {
            layoutManager = GridLayoutManager(this@ItemsAct, 2)
            adapter = ProductsAdapter(products)
        }

        setSupportActionBar(toolBar)
        val actionBar = supportActionBar
        actionBar?.title = "Navigation Drawer"

        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(this, drawerLayout, toolBar, R.string.Open, R.string.Close)
        {}

        drawerToggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        floatingActionButton2.setOnClickListener {
            openCloseNavigationDrawer()
        }
        nav_view.setNavigationItemSelectedListener {
            drawerLayout.closeDrawers()
            true
        }
        }

    fun openCloseNavigationDrawer() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            drawerLayout.openDrawer(GravityCompat.START)
        }
    }



}

