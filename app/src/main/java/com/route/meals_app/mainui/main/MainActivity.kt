@file:OptIn(ExperimentalGlideComposeApi::class)

package com.route.meals_app.mainui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.route.meals_app.data.model.categories.CategoryItem
import com.route.meals_app.ui.theme.MealsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MealsAppTheme {
                MealsContent()
            }
        }
    }
}

@Composable
fun MealsContent(viewModel: MainViewModel = hiltViewModel()) {
    LaunchedEffect(key1 = Unit) {
        viewModel.getAllCategories()
    }
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(viewModel.categoriesList.size){position->
            MealsCard(categoryItem = viewModel.categoriesList[position])
        }
    }
}

@Composable
fun MealsCard(categoryItem: CategoryItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        ConstraintLayout {
            val (image, title, description) = createRefs()
            GlideImage(model = categoryItem.strCategoryThumb,
                contentDescription = "Category meals image",
                modifier = Modifier
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    }
                    .size(80.dp))
            Text(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                text = categoryItem.strCategory!!,
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(title) {
                        start.linkTo(image.end)
                        top.linkTo(image.top)
                        bottom.linkTo(description.top)
                    })
            Text(
                fontSize = 17.sp,
                fontWeight = FontWeight.Light,
                text = categoryItem.strCategoryDescription!!,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp)
                    .constrainAs(description) {
                        top.linkTo(title.bottom)
                        start.linkTo(image.end)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    },
                overflow = TextOverflow.Ellipsis,
                maxLines = 2)
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MealsCardPrev() {
    MealsCard(CategoryItem(0, "Category test ", "Description test", "1", "Image Url"))
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MealsPrev() {

}