package com.example.jetpackcomposedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontSynthesis.Companion.Weight
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting()
                    TextAnnotate()
                    CustomText()
                }
            }
        }
    }
}

@Composable
fun Greeting( ){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter){
        Box(modifier = Modifier
            .background(Color.Blue),
            contentAlignment = Alignment.Center)
        {
            Box(modifier = Modifier
                .height(45.dp)
                .width(45.dp)
                .background(Color.Cyan))
            Text(text ="BOX Jetpack compose demo", fontSize = 25.sp )
        }
    }

}

@Preview
@Composable
fun TextAnnotate(){
    Text(
        buildAnnotatedString {
            withStyle(style = ParagraphStyle()){
                withStyle(style= SpanStyle(
                    color = MaterialTheme.colors.primary,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold)
                ){
                    append("A")
                }
            }

            append("B")
            append("C")
            append("D")
        }, modifier = Modifier.width(200.dp)
    )
}

@Composable
fun CustomText(){
    Text(text = "HEY!!".repeat(30), maxLines = 2, overflow = TextOverflow.Ellipsis)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeDemoTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            //CustomText()
            SuperscriptText(normalText = "HI", superText = "A")
        }
        //TextAnnotate()
        // Greeting()
    }
}

@Composable
fun SuperscriptText(
    normalText:String,
    NormalTextSize:TextUnit=MaterialTheme.typography.subtitle1.fontSize,
    superText:String,
    SuperTextSize:TextUnit=MaterialTheme.typography.overline.fontSize,
    SuperFontWeight:FontWeight= FontWeight.Normal)
{
    Text(buildAnnotatedString {
        withStyle(style = SpanStyle(
            fontSize = NormalTextSize)
        )
        {
            append(normalText)
        }
        withStyle(style = SpanStyle(
            fontSize = SuperTextSize,
            fontWeight = SuperFontWeight,
            baselineShift = BaselineShift.Subscript,
            // baselineShift = BaselineShift.Superscript
        )
        ){
            append(superText)
        }
    }
    )
}