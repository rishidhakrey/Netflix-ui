package com.example.netflix

import android.graphics.Movie
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflix.ui.theme.NetflixTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .verticalScroll(rememberScrollState())

            ) {
                TopAppSection()
                NetflixContentChooser()
                FeaturedMovieSection()
                addMovieList(movieType ="Watch It Again")
                addMovieList(movieType ="Drama Movies")
                addMovieList(movieType ="Action Movies")
                addMovieList(movieType ="New Release")

            }

        }
    }

  @Composable
  @Preview
  fun TopAppSection(){
      Row (
          modifier = Modifier
              .fillMaxWidth()
              .background(Color.Black)
              .padding(top = 6.dp),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically


      ){
          Image(painter = painterResource(id =R.drawable.netflixicon), contentDescription ="icon", modifier =Modifier.padding(6.dp) )
          Row() {
              Image(painter = painterResource(id =R.drawable.ic_search), contentDescription ="search", modifier = Modifier
                  .padding(end = 14.dp)
                  .size(32.dp))

              Image(painter = painterResource(id =R.drawable.ic_circle), contentDescription ="profile", modifier = Modifier
                  .padding(end = 6.dp)
                  .size(32.dp))


          }

      }
  }
    @Composable
    @Preview
    fun NetflixContentChooser(){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(horizontal = 30.dp, vertical = 12.dp),
            horizontalArrangement =Arrangement.SpaceBetween,
            verticalAlignment =Alignment.CenterVertically

        ) {
            Text(text ="TV Shows", color = Color.LightGray, fontSize = 20.sp)
            Text(text ="Movies", color =Color.LightGray, fontSize = 20.sp)
            Row() {
                Text(text ="Categories", color =Color.LightGray, fontSize = 20.sp)
                Image(painter = painterResource(id =R.drawable.ic_drop), contentDescription ="drop icon" )

            }

            
        }
    }

    @Composable
    @Preview

    fun FeaturedMovieSection(){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(top = 60.dp),
            horizontalAlignment =Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id =R.drawable.theadamproject), contentDescription ="the adam project",
                modifier =Modifier.size(320.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 60.dp, start = 60.dp, end = 60.dp),
                horizontalArrangement =Arrangement.SpaceBetween
            ) {
                Text(text ="Adventure", color = Color.White)
                Text(text ="Thriller", color = Color.White)
                Text(text ="Drama", color = Color.White)
                Text(text ="Hollywood", color =Color.White)

            }
            Row(
                modifier = Modifier
                    .padding(top = 20.dp, start = 80.dp, end = 80.dp)
                    .fillMaxWidth(),
                horizontalArrangement =Arrangement.SpaceBetween
            ) {
                Column(
                    horizontalAlignment =Alignment.CenterHorizontally
                ) {
                    Image(painter = painterResource(id =R.drawable.ic_add), contentDescription ="add" )
                    Text(text ="My List", color =Color.White)

                }

                Button(onClick ={},
                    colors =ButtonDefaults.buttonColors(Color.White),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(text ="Play", color =Color.Black, fontSize = 18.sp)

                }
                Column(
                    horizontalAlignment =Alignment.CenterHorizontally
                ) {
                    Image(painter = painterResource(id =R.drawable.ic_info), contentDescription ="info",
                        modifier =Modifier.size(30.dp))
                    Text(text ="info", color =Color.White)

                }

            }

        }
    }
    
    @Composable

    fun addMovieList(movieType: String){


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
        ) {
            Text(text =movieType, color =Color.LightGray,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 20.dp, start = 12.dp)
            )
          LazyRow(
              modifier =Modifier.padding(top =4.dp)
          ){
              itemsIndexed(getRandomMovieList()){
                  index, item ->
                  MovieItemUiModel(imageRes =item.image)
              }
          }
            
            
        }
    }

    @Composable
    fun MovieItemUiModel(
        imageRes:Int
    ){
      androidx.compose.foundation.Image(painter = painterResource(id =imageRes), contentDescription ="",
          modifier = Modifier

              .height(180.dp)
              .width(132.dp))
    }

    fun getRandomMovieList():List<MovieDataModel>{
        val listOfMovies= mutableListOf<MovieDataModel>()
        listOfMovies.add(MovieDataModel(R.drawable.jaanejaan))
        listOfMovies.add(MovieDataModel(R.drawable.haseendilruba))
        listOfMovies.add(MovieDataModel(R.drawable.rednotice))
        listOfMovies.add(MovieDataModel(R.drawable.underground))
        listOfMovies.add(MovieDataModel(R.drawable.paggleit))
        listOfMovies.add(MovieDataModel(R.drawable.theadamproject))
        listOfMovies.add(MovieDataModel(R.drawable.khufiya))
        listOfMovies.add(MovieDataModel(R.drawable.theamazingspiderman))
        listOfMovies.shuffle()
        return listOfMovies

    }

}


  data class MovieDataModel(
      val image: Int
  )