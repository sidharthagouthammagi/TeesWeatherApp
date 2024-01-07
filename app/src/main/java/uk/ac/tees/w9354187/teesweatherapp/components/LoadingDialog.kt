import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import uk.ac.tees.w9354187.teesweatherapp.R
import uk.ac.tees.w9354187.teesweatherapp.screens.login.LoginViewModel
import uk.ac.tees.w9354187.teesweatherapp.screens.register.RegisterViewModel

@Composable
fun LoadingDialog() {
        Dialog(onDismissRequest = {}) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .background(
                        color = colorResource(id = R.color.white),
                        shape = RoundedCornerShape(8.dp)
                    )
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(35.dp)
                        .height(35.dp),
                    color = colorResource(id = R.color.blue)
                )
            }
        }
}