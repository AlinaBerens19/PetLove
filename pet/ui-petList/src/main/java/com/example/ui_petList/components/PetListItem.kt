package com.example.ui_petList.components
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


import com.skydoves.landscapist.glide.GlideImage


//@Preview
@Composable
fun PetListItem(
    likes: Int,
    name: String,
    breed: String,
    image: String?,
    id: Int,
    id_: String,
    onDetailScreenNavigate: (String) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp)
                .clickable { onDetailScreenNavigate(id_) },

            ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (image == null) {
                    Image(
                        painter = painterResource(id = id),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(130.dp),
                        contentDescription = null // decorative element
                    )
                }
                else {

                    GlideImage(
                        imageModel = Uri.parse(image),
                        modifier = Modifier
                            .size(130.dp))

                }

                Spacer(modifier = Modifier.width(50.dp))

                Column() {
                    Text(
                        text = name,
                        style = MaterialTheme.typography.h6,
                        color = Color.DarkGray,
                    )
                    Text(
                        text = breed,
                        style = MaterialTheme.typography.subtitle1,
                        color = Color.Gray)
                    Text(
                        text = "$likes likes",
                    )

                }
            }
        }
    }
}