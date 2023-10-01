package eu.gaudian.androidautoshortcut

import android.content.ActivityNotFoundException
import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import eu.gaudian.androidautoshortcut.ui.theme.AndroidAutoShortcutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidAutoShortcutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }

                val packageName = "com.google.android.projection.gearhead"
                val className =
                    "com.google.android.projection.gearhead.companion.settings.DefaultSettingsActivity"

                val intent = Intent()
                intent.component = ComponentName(packageName, className)
                intent.action = Intent.ACTION_VIEW
                try {
                    startActivity(intent)
                    finish()
                } catch (e: ActivityNotFoundException) {
                    val playStorePackageName = "com.android.vending"
                    val androidAutoAppUrl =
                        "https://play.google.com/store/apps/details?id=com.google.android.projection.gearhead"
                    val playStoreIntent = Intent(Intent.ACTION_VIEW)
                    //playStoreIntent.data = Uri.parse("market://details?id=$androidAutoAppUrl")
                    //playStoreIntent.setPackage(playStorePackageName)

                        val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(androidAutoAppUrl))
                        startActivity(webIntent)
                        finish()

                }


            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidAutoShortcutTheme {
        Greeting("Android")
    }
}


