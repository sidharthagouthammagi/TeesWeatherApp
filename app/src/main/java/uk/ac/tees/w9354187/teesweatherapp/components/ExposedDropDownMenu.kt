package uk.ac.tees.w9354187.teesweatherapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import uk.ac.tees.w9354187.teesweatherapp.data.model.Category

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedDropdownMenu(

    modifier: Modifier = Modifier,
    menuList: List<Category>,
    selectedItem: MutableState<Category>
) {

    var expanded by remember { mutableStateOf(false) }

    // We want to react on tap/press on TextField to show menu
    ExposedDropdownMenuBox(
        expanded = expanded,
        modifier = Modifier.fillMaxWidth(),
        onExpandedChange = { expanded = !expanded },
    ) {
        TextField(
            // The `menuAnchor` modifier must be passed to the text field for correctness.
            modifier = modifier.menuAnchor().fillMaxWidth(),
            readOnly = true,
            value = selectedItem.value.title,
            onValueChange = {},
            label = { Text("Room Category") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
            leadingIcon = {
                Image(
                    modifier = Modifier.size(40.dp),
                    painter = painterResource(id = selectedItem.value.imageResId),
                    contentDescription = ""
                )
            }
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            menuList.forEach { selectionOption ->
                DropdownMenuItem(
                    text = {

                        Row() {
                            Image(
                                modifier = Modifier.size(40.dp),
                                painter = painterResource(id = selectionOption.imageResId),
                                contentDescription = ""
                            )
                            Text(
                                modifier = Modifier.padding(top = 14.dp, start = 16.dp),
                               text = selectionOption.title,
                                textAlign = TextAlign.Center
                            )
                        }


                    },
                    onClick = {
                        selectedItem.value = selectionOption
                        expanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                )
            }
        }
    }
}