package com.dimas.alodokter.core.data

import android.content.Context
import com.dimas.alodokter.core.R
import com.dimas.alodokter.core.model.FoodHome

class DataImage(private val context: Context) {

    fun getListImage() : List<FoodHome>{
        val list = ArrayList<FoodHome>()
        list.add(FoodHome(1, R.drawable.burger))
        list.add(FoodHome(2, R.drawable.cake))
        list.add(FoodHome(3, R.drawable.ice_cream))
        list.add(FoodHome(4, R.drawable.kebab))
        list.add(FoodHome(5, R.drawable.pizza))
        return list;
    }

    fun getListDetail(index: Int) : List<String>{
        val list = ArrayList<String>()

        when(index){
            1 -> {
                list.add("https://www.jessicagavin.com/wp-content/uploads/2020/05/grilled-burgers-34-1200.jpg")
                list.add("https://www.thecookierookie.com/wp-content/uploads/2019/12/smash-burgers-recipe-7-of-8.jpg")
                list.add("https://www.tasteofhome.com/wp-content/uploads/2018/01/Scrum-Delicious-Burgers_EXPS_CHMZ19_824_B10_30_2b-1.jpg")
            }
            2 -> {
                list.add("https://www.lifeloveandsugar.com/wp-content/uploads/2018/04/Raspberry-Chocolate-Layer-Cake3.jpg")
                list.add("https://www.hummingbirdhigh.com/wp-content/uploads/2020/05/01_Rainbow-Unicorn-Cake_IMG_0008.jpg")
                list.add("https://www.brides.com/thmb/TkiFq7ZUGBGbWIZdCSALksPCwJo=/640x640/smart/filters:no_upscale()/nakedcakewithflowers-f7a0d6c45d4e45ce861b6fe1beeca8b9.jpg")
            }
            3 -> {
                list.add("https://akcdn.detik.net.id/community/media/tsworld/050920190903455cd3ecf1b1fa8es%20krim.jpg?w=780&q=90")
                list.add("https://www.julieseatsandtreats.com/wp-content/uploads/2020/06/Rainbow-Ice-Cream-14-of-16.jpg")
                list.add("https://www.mccourier.com/wp-content/uploads/2021/02/Ice-Cream-Market1.jpg")
            }
            4 -> {
                list.add("https://images.tokopedia.net/img/cache/500-square/VqbcmM/2020/8/31/05ff3996-7e2b-419b-be2b-c32ac74e8599.jpg?ect=4g")
                list.add("https://i.pinimg.com/736x/c1/35/49/c13549918aa1bc4e11627ca64bd851fa.jpg")
                list.add("https://awsimages.detik.net.id/community/media/visual/2018/11/01/272bdcd6-8254-4f12-91c2-2b556416151b.jpeg?w=700&q=90")
            }
            5 -> {
                list.add("https://ik.imagekit.io/tvlk/cul-asset/guys1L+Yyer9kzI3sp-pb0CG1j2bhflZGFUZOoIf1YOBAm37kEUOKR41ieUZm7ZJ/tvlk-prod-cul-assets/culinary/asset/REST_557-842x720-FIT_AND_TRIM-ebc88d9f46405c3e03e4208b0e18b88c.jpeg?tr=q-40,c-at_max,w-1080,h-1920&_src=imagekit")
                list.add("https://www.jessicagavin.com/wp-content/uploads/2020/07/hawaiian-pizza-16-1200.jpg")
                list.add("https://natashaskitchen.com/wp-content/uploads/2020/04/Pizza-Dough-Best-Pizza-Crust-Recipe-3.jpg")
            }

        }
        return list;
    }
}