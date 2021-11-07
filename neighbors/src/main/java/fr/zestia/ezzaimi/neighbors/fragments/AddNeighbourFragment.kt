package fr.zestia.ezzaimi.neighbors.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import androidx.fragment.app.Fragment
import fr.zestia.ezzaimi.neighbors.NavigationListener
import fr.zestia.ezzaimi.neighbors.R
import fr.zestia.ezzaimi.neighbors.data.NeighborRepository
import fr.zestia.ezzaimi.neighbors.databinding.AddNeighborBinding
import fr.zestia.ezzaimi.neighbors.models.Neighbor

class AddNeighbourFragment : Fragment(), TextWatcher {
    private lateinit var binding: AddNeighborBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // return inflater.inflate(R.layout.add_neighbor, container, false)
        binding = AddNeighborBinding.inflate(inflater, container, false)
        val view = binding.root

        (activity as? NavigationListener)?.updateTitle(R.string.add_title)
//        binding.saveBtn?.setOnClickListener {
//            (activity as? NavigationListener)?.let {
//                it.showFragment(ListNeighborsFragment())
//            }
//        }
        binding.saveBtn?.setOnClickListener {
//            getneighborvalue
            with(binding) {
                val avatarUrlvalue = image.text.toString()
                val namevalue = nom.text.toString()
                val addressvalue = adresse.text.toString()
                val phonevalue = telephone.text.toString()
                val aboutMevalue = apropos.text.toString()
                val webSitevalue = website.text.toString()

                val neigbour = Neighbor(
                    NeighborRepository.getInstance().getIdNeigbour(),
                    namevalue,
                    avatarUrlvalue,
                    addressvalue,
                    phonevalue,
                    aboutMevalue,
                    false,
                    webSitevalue
                )
                NeighborRepository.getInstance().addNeighbour(neigbour)
            }

            (activity as? NavigationListener)?.showFragment(ListNeighborsFragment())
        }
        with(binding) {
            image.addTextChangedListener(this@AddNeighbourFragment)
            nom.addTextChangedListener(this@AddNeighbourFragment)
            telephone.addTextChangedListener(this@AddNeighbourFragment)
            website.addTextChangedListener(this@AddNeighbourFragment)
            adresse.addTextChangedListener(this@AddNeighbourFragment)
            apropos.addTextChangedListener(this@AddNeighbourFragment)
        }

        return view
    }

    private fun validbtn() {
        with(binding) {

            val imageContraintes: Boolean = !image.text.isNullOrEmpty()
            val nameContraintes: Boolean = !nom.text.isNullOrEmpty()
            val telephoneContraintes: Boolean = !telephone.text.isNullOrEmpty()
            val websiteContraintes: Boolean = !website.text.isNullOrEmpty()
            val adressdContraintes: Boolean = !adresse.text.isNullOrEmpty()
            val aproposContraintes: Boolean = !apropos.text.isNullOrEmpty()

            val telephoneValid: Boolean = isValidtelephone(telephone.text)
            if (!telephoneValid && telephoneContraintes) {
                telephone.error = "le format doit être 0X XX XX XX XX XX"
            }

            val imageUrlValid: Boolean = isValidUrl(image.text)
            if (!imageUrlValid && imageContraintes) {
                image.error = "lien d'image invalide"
            }

            val websiteUrlValid: Boolean = isValidUrl(website.text)
            if (!websiteUrlValid && websiteContraintes) {
                website.error = "lien invalide"
            }

            saveBtn?.isEnabled =
                nameContraintes &&
                adressdContraintes &&
                telephoneContraintes &&
                websiteContraintes &&
                aproposContraintes &&
                imageContraintes &&
                telephoneValid &&
                imageUrlValid &&
                websiteUrlValid
        }
    }

    private fun isValidtelephone(target: CharSequence?): Boolean {
        return (
            (
                (target.toString()).startsWith("07") ||
                    (target.toString()).startsWith("06")
                ) &&
                target.toString().length == 10
            )
    }

    private fun isValidUrl(target: CharSequence?): Boolean {
        return URLUtil.isValidUrl(target.toString())
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        validbtn()
    }

    override fun afterTextChanged(s: Editable?) {
    }
}
