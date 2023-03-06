package uz.gita.banking_app_geberit.navigator

import cafe.adriel.voyager.androidx.AndroidScreen

/*CREATED BY
MATKARIMOV KHAYRULLO 
IN ()
*/
interface AppNavigation {
    fun replaceWith(screen: AndroidScreen)
    fun back()
    fun navigateTo(screen: AndroidScreen)
}