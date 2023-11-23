import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AlertDialog(
    onDismissRequest: () -> Unit = {} ,
    alertMessage :  @Composable () -> Unit= {},
    dismissButton: @Composable() (() -> Unit)?,
    confirmButton: @Composable () -> Unit
    ) {
    AlertDialog(
        onDismissRequest =  onDismissRequest ,
        confirmButton = confirmButton,
        dismissButton= dismissButton,
        text = alertMessage ,
        modifier = Modifier.fillMaxWidth()
    )
}

