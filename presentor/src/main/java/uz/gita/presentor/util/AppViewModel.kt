package uz.gita.presentor.util

/*CREATED BY
MATRIMONIAL HAYRULLAH
IN ()
*/
import org.orbitmvi.orbit.ContainerHost

interface AppViewModel<INTENT : Any, STATE : Any, SIDE_EFFECT : Any> :
    ContainerHost<STATE, SIDE_EFFECT> {
    fun onEventDispatcher(intent: INTENT)
}
