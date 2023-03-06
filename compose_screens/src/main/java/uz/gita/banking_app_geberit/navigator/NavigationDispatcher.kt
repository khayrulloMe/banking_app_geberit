package uz.gita.banking_app_geberit.navigator

import cafe.adriel.voyager.androidx.AndroidScreen
import kotlinx.coroutines.flow.MutableSharedFlow
import uz.gita.banking_app_geberit.utils.NavigatorArg

/*CREATED BY
MATKARIMOV KHAYRULLO 
IN ()
*/
class NavigationDispatcher:AppNavigation,NavigationHandler {
    override fun replaceWith(screen: AndroidScreen) {

    }

    override fun back() {

    }

    override fun navigateTo(screen: AndroidScreen) {

    }

    override val navStack: MutableSharedFlow<NavigatorArg> = MutableSharedFlow()
    private fun navigator(arg:NavigatorArg){

    }

}