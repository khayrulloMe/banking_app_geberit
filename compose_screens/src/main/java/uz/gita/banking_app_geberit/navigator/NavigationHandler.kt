package uz.gita.banking_app_geberit.navigator

import kotlinx.coroutines.flow.Flow
import uz.gita.banking_app_geberit.utils.NavigatorArg

/*CREATED BY
MATKARIMOV KHAYRULLO 
IN ()
*/
interface NavigationHandler {
    val navStack: Flow<NavigatorArg>
}