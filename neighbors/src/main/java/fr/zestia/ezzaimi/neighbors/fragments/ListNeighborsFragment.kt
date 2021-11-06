package fr.zestia.ezzaimi.neighbors.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import fr.zestia.ezzaimi.neighbors.NavigationListener
import fr.zestia.ezzaimi.neighbors.R
import fr.zestia.ezzaimi.neighbors.adapters.ListNeighborHandler
import fr.zestia.ezzaimi.neighbors.adapters.ListNeighborsAdapter
import fr.zestia.ezzaimi.neighbors.data.NeighborRepository
import fr.zestia.ezzaimi.neighbors.models.Neighbor

class ListNeighborsFragment : Fragment(), ListNeighborHandler {

    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as? NavigationListener)?.updateTitle(R.string.list_title)
//        return inflater.inflate(R.layout.list_neighbors_fragment, container, false)
        val view = inflater.inflate(R.layout.list_neighbors_fragment, container, false)
        val addbutton = view.findViewById<FloatingActionButton>(R.id.add_btn)
        addbutton.setOnClickListener {
            (activity as? NavigationListener)?.showFragment(AddNeighbourFragment())
        }

        recyclerView = view.findViewById(R.id.neighbors_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        refrech()
    }

    override fun onDeleteNeibor(neighbor: Neighbor) {
//        NeighborRepository.getInstance().removeNeighbour(neighbor)
//        refrech()
        activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setMessage(R.string.Confirmation_Message)
                .setPositiveButton(
                    R.string.btn_oui
                ) { _, _ ->
                    NeighborRepository.getInstance().removeNeighbour(neighbor)
                    refrech()
                }
                .setNegativeButton(
                    R.string.btn_non
                ) { _, _ ->
                    // User cancelled the dialog
                }
            // Create the AlertDialog object and return it
            builder.create().show()
        }
    }

//    fun createNeighbour(neighbor: Neighbor) {
//        NeighborRepository.getInstance().addNeighbour(neighbor)
//        refrech()
//    }

    fun refrech() {
        val neighbors = NeighborRepository.getInstance().getNeighbours()
        val adapter = ListNeighborsAdapter(neighbors, this)
        recyclerView.adapter = adapter
    }
}
