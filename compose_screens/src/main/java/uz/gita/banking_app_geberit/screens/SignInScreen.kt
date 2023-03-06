package uz.gita.banking_app_geberit.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.androidx.AndroidScreen
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.orbitmvi.orbit.compose.collectAsState
import uz.gita.banking_app_geberit.R
import uz.gita.banking_app_geberit.ui.theme.ApplicationTheme
import uz.gita.banking_app_geberit.ui.theme.Theme
import uz.gita.domain.modul.auth.request.SignInRequestModel
import uz.gita.presentor.mvi.sign_in.vm.SignInIntent
import uz.gita.presentor.mvi.sign_in.vm.SignInUiState
import uz.gita.presentor.mvi.sign_in.vm.SignInViewModel
import uz.gita.presentor.mvi.sign_in.vm.impl.SignInViewModelImp

/*CREATED BY
MATKARIMOV KHAYRULLO 
IN ()
*/
class SignInScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel: SignInViewModel = getViewModel<SignInViewModelImp>()
        val uiState = viewModel.collectAsState().value
        SignInScreenContent(uiState, viewModel::onEventDispatcher, "")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreenContent(
    uiState: SignInUiState,
    onEventDispatcher: (SignInIntent) -> Unit,
    message: String
) {
    var phone by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var isErrorPhone by remember {

        mutableStateOf(false)
    }
    var isErrorPassword by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    when (uiState) {
        is SignInUiState.Loading -> {
            if (uiState.isLoading) {
                CircularProgressIndicator(modifier = Modifier)
            }
        }

    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            var isShowKey by remember {
                mutableStateOf(false)
            }
            val showIcon by remember {
                mutableStateOf(R.drawable.key_on)
            }
            val hideIcon by remember {
                mutableStateOf(R.drawable.key_off)
            }
            Column(verticalArrangement = Arrangement.Center) {

                OutlinedTextField(
                    modifier = Modifier.padding(8.dp),
                    value = phone,
                    minLines = 1,
                    textStyle = MaterialTheme.typography.bodyMedium,
                    singleLine = true,
                    onValueChange = {

                        if (it.length < 10) {
                            phone = it
                        }
                        isErrorPhone = it.length < 9

                    },

                    keyboardOptions = KeyboardOptions(
                        autoCorrect = true,
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    interactionSource = MutableInteractionSource(),

                    shape = RoundedCornerShape(30),

                    supportingText = {
                        Text(
                            text = "phone",
                            fontSize = MaterialTheme.typography.bodySmall.fontSize

                        )
                    },
                    maxLines = 1,
                    isError = isErrorPhone,
                    leadingIcon = {
                        Text(
                            text = "+9989",
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    },
                    placeholder = { Text(text = "99 999 99 99", color = Color.Gray) }
                )



                OutlinedTextField(
                    modifier = Modifier.padding(8.dp),
                    value = password,
                    onValueChange = {
                        if (it.length <= 10) {
                            password = it
                        }
                        isErrorPassword = it.length <= 5
                    },
                    keyboardOptions = KeyboardOptions(
                        autoCorrect = true,
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    placeholder = {
                        Text(text = "password", color = Color.Gray)
                    },
                    trailingIcon = {
                        IconButton(
                            modifier = Modifier,
                            onClick = { isShowKey = !isShowKey }
                        ) {
                            Icon(
                                painter = if (isShowKey) painterResource(id = showIcon) else painterResource(
                                    hideIcon
                                ), contentDescription = ""
                            )
                        }
                    },
                    visualTransformation = if (isShowKey) VisualTransformation.None else PasswordVisualTransformation(),
                    singleLine = true,
                    isError = isErrorPassword,
                    supportingText = { Text(text = "password") },
                    maxLines = 1,
                    shape = RoundedCornerShape(30),
                )
                Button(
                    modifier = Modifier.align(Alignment.End),
                    onClick = {
                        isErrorPhone = phone.length < 9

                        onEventDispatcher(
                            SignInIntent.SignIn(
                                SignInRequestModel(password = password, phone = phone)
                            )
                        )
                    }) {
                    Text(text = "sign in")
                }
            }

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .align(Alignment.BottomCenter),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "For registration",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground
            )

            TextButton(onClick = { onEventDispatcher(SignInIntent.OpenSignUp) }) {
                Text(
                    text = "Sign Up",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            //theme
            val radioOptions = listOf(Theme.LITE, Theme.DARK, Theme.TERTIARY)
            val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[2]) }
            Column(

                modifier = Modifier,
                verticalArrangement = Arrangement.Center,

                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Column {
                    radioOptions.forEach { text ->
                        Row(
                            Modifier
                                .selectable(
                                    selected = (text == selectedOption),
                                    onClick = { onOptionSelected(text) }
                                )
                                .padding(horizontal = 16.dp)
                        ) {

                            RadioButton(
                                selected = (text == selectedOption),
                                modifier = Modifier.padding(all = Dp(value = 8F)),
                                onClick = {
                                    onOptionSelected(text)
                                    ApplicationTheme.theme.value = text

                                }
                            )
                            Text(
                                text = text.toString(),
                                style = MaterialTheme.typography.labelMedium,
                                modifier = Modifier.padding(start = 16.dp),

                                )
                        }
                    }
                }
            }


        }
    }

}
