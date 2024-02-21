package dev.codeninja.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.codeninja.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ArtSpaceTheme {
				// A surface container using the 'background' color from the theme
				Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
					ArtSpaceScreen()
				}
			}
		}
	}
}

@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {
	val firstPainting = R.drawable.mona_liza
	val secondPainting = R.drawable.the_birth_of_venus
	val thirdPainting = R.drawable.the_creation_of_adam
	val fourthPainting = R.drawable.the_last_supper
	val fifthPainting = R.drawable.sacred_and_profane_love
	val sixthPainting = R.drawable.the_ancient_of_days
	val seventhPainting = R.drawable.girl_with_a_pearl_earring

	var title by remember {
		mutableStateOf(R.string.mona_lisa)
	}

	var year by remember {
		mutableStateOf(R.string.mona_lisa_year)
	}

	var currentPainting by remember {
		mutableStateOf(firstPainting)
	}

	var imageResource by remember {
		mutableStateOf(currentPainting)
	}

	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(16.dp), // Adding padding to center the content
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		PaintingDisplay(currentPainting = currentPainting)
		Spacer(modifier = Modifier.height(16.dp))
		PaintingTitle(title = title, year = year)
		Spacer(modifier = Modifier.height(25.dp))
		Row(
			modifier = Modifier.fillMaxWidth(),
			horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
			verticalAlignment = Alignment.CenterVertically
		) {
			// Previous Button
			Button(
				onClick = {
					when (currentPainting) {
						firstPainting -> {
							currentPainting = seventhPainting
							title = R.string.girl_with_a_pearl_earring
							year = R.string.girl_with_a_pearl_earring_year
						}
						secondPainting -> {
							currentPainting = firstPainting
							title = R.string.mona_lisa
							year = R.string.mona_lisa_year
						}
						thirdPainting -> {
							currentPainting = secondPainting
							title = R.string.the_brith_of_venus
							year = R.string.the_brith_of_venus_year
						}
						fourthPainting -> {
							currentPainting = thirdPainting
							title = R.string.the_creation_of_adam
							year = R.string.the_creation_of_adam_year
						}
						fifthPainting -> {
							currentPainting = fourthPainting
							title = R.string.the_last_supper
							year = R.string.the_last_supper_year
						}
						sixthPainting -> {
							currentPainting = fifthPainting
							title = R.string.sacred_and_profane_love
							year = R.string.sacred_and_profane_love_year
						}
						else -> {
							currentPainting = sixthPainting
							title = R.string.the_ancient_of_days
							year = R.string.the_ancient_of_days_year
						}
					}
				},
				colors = ButtonDefaults.buttonColors(
					backgroundColor = colorResource(id = R.color.gray_900)
				),
				elevation = ButtonDefaults.elevation(
					defaultElevation = 1.dp,
					pressedElevation = 0.dp,
					focusedElevation = 0.dp
				)
			) {
				Text(
					text = "Previous",
					fontSize = 16.sp,
					fontWeight = FontWeight.Medium,
					color = colorResource(id = R.color.pink_300)
				)
			}

			// Next Button
			Button(
				onClick = {
					when (currentPainting) {
						firstPainting -> {
							currentPainting = secondPainting
							title = R.string.the_brith_of_venus
							year = R.string.the_brith_of_venus_year
						}
						secondPainting -> {
							currentPainting = thirdPainting
							title = R.string.the_creation_of_adam
							year = R.string.the_creation_of_adam_year
						}
						thirdPainting -> {
							currentPainting = fourthPainting
							title = R.string.the_last_supper
							year = R.string.the_last_supper_year
						}
						fourthPainting -> {
							currentPainting = fifthPainting
							title = R.string.sacred_and_profane_love
							year = R.string.sacred_and_profane_love_year
						}
						fifthPainting -> {
							currentPainting = sixthPainting
							title = R.string.the_ancient_of_days
							year = R.string.the_ancient_of_days_year
						}
						sixthPainting -> {
							currentPainting = seventhPainting
							title = R.string.girl_with_a_pearl_earring
							year = R.string.girl_with_a_pearl_earring_year
						}
						else -> {
							currentPainting = firstPainting
							title = R.string.mona_lisa
							year = R.string.mona_lisa_year
						}
					}
				},
				colors = ButtonDefaults.buttonColors(
					backgroundColor = colorResource(id = R.color.pink_300)
				),
				elevation = ButtonDefaults.elevation(
					defaultElevation = 1.dp,
					pressedElevation = 0.dp,
					focusedElevation = 0.dp
				)
			) {
				Text(
					text = "Next",
					fontSize = 16.sp,
					fontWeight = FontWeight.Medium,
					color = colorResource(id = R.color.gray_900)
				)
			}
		}
	}
}


@Composable
fun PaintingDisplay(
	modifier: Modifier = Modifier,
	@DrawableRes currentPainting: Int
) {
	if (currentPainting != 0) {
		Image(
			painter = painterResource(currentPainting),
			contentDescription = stringResource(id = R.string.the_brith_of_venus),
			modifier = modifier
				.fillMaxWidth()
				.padding(horizontal = 16.dp) // Adding padding for aesthetics
				.aspectRatio(1f), // Ensures image maintains aspect ratio
			contentScale = ContentScale.Fit
		)
	} else {
		// Placeholder when no painting is selected
		Box(
			modifier = modifier
				.fillMaxWidth()
				.height(300.dp), // Set a fixed height for placeholder
			contentAlignment = Alignment.Center
		) {
			Text(
				text = "Select a Painting",
				fontSize = 20.sp,
				color = Color.Gray
			)
		}
	}
}

@Composable
fun PaintingTitle(
	@StringRes title: Int,
	@StringRes year: Int
) {
	Column (
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		// Artwork title
		Text(
			text = stringResource(id = title),
			fontWeight = FontWeight.Bold,
			color = colorResource(id = R.color.pink_200),
			fontSize = 32.sp
		)

		// Artwork year
		Text(
			text = "— ${stringResource(id = year)} —",
			fontSize = 18.sp,
			fontWeight = FontWeight.Medium,
			color = colorResource(id = R.color.gray_300)
		)
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	ArtSpaceTheme {
		ArtSpaceScreen()
	}
}