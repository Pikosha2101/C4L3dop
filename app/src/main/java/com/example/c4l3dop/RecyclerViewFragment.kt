package com.example.c4l3dop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.c4l3dop.adapters.FirstRecyclerAdapter
import com.example.c4l3dop.adapters.SecondRecyclerAdapter
import com.example.c4l3dop.databinding.RecyclerViewFragmentBinding
import com.example.c4l3dop.models.FirstRecyclerModel
import com.example.c4l3dop.models.SecondRecyclerModel

class RecyclerViewFragment : Fragment(R.layout.recycler_view_fragment) {
    private var _binding : RecyclerViewFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter1: FirstRecyclerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        _binding = RecyclerViewFragmentBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        adapter1 = FirstRecyclerAdapter(
            //не открывать тут ад
            listOf(
                FirstRecyclerModel(
                    "BMW",
                    listOf(
                       SecondRecyclerModel(
                           "https://hips.hearstapps.com/hmg-prod/amv-prod-cad-assets/wp-content/uploads/2017/04/2017-BMW-540i-102.jpg?crop=0.811xw:0.664xh;0.0705xw,0.215xh&resize=1200:*",
                           "540i F90",
                           4.1
                       ),
                        SecondRecyclerModel(
                            "https://www.daehler-tuning.com/wp-content/uploads/2021/07/BMW-3-series-Sedan-M340i-xDrive-G20-12-min.jpg",
                            "335i G20",
                            4.2
                        ),
                        SecondRecyclerModel(
                            "https://avatars.mds.yandex.net/get-verba/937147/2a000001863cb37ff4d6b6617f77c29fb919/cattouch",
                            "X6M G96",
                            4.3
                        ),
                        SecondRecyclerModel(
                            "https://www.topgear.com/sites/default/files/cars-car/image/2018/10/bmw_8_coupe_106.jpg",
                            "850d G92",
                            4.4
                        ),
                        SecondRecyclerModel(
                            "https://www.blackbettymotors.com/bmw-serie-4-430d-xdrive-coupe-m-sport---bva--coupe-f32-f82-lci-430d-xdrive-phase-2,fm-svositec!fd001!276628663!n.jpg",
                            "430d F82",
                            4.5
                        ),
                        SecondRecyclerModel(
                            "https://www.cnet.com/a/img/resize/107256f2018ac3f340a13435e9cb07845220664e/hub/2017/02/03/ba3cac91-31f2-409a-83c9-5d6add148c08/2017-bmw-m760i-xdrive-1.jpg?auto=webp&width=1200",
                            "M760i F11",
                            4.6
                        ),
                    )
                ),
                FirstRecyclerModel(
                    "Mercedes",
                    listOf(
                        SecondRecyclerModel(
                            "https://media.ed.edmunds-media.com/mercedes-benz/g-class/2023/oem/2023_mercedes-benz_g-class_4dr-suv_amg-g-63_fq_oem_10_1280.jpg",
                            "G500 W463",
                            4.1
                        ),
                        SecondRecyclerModel(
                            "https://i.pinimg.com/originals/28/26/2c/28262c708b10db65658512a2078bd78c.jpg",
                            "S63 W222",
                            4.2
                        ),
                        SecondRecyclerModel(
                            "https://bringatrailer.com/wp-content/uploads/2022/04/DSC01100-1-scaled-bNtZwm.jpg?fit=940%2C627",
                            "E430 W124",
                            4.3
                        ),
                        SecondRecyclerModel(
                            "https://media.autoweek.nl/m/g94yutfblm4t_800.jpg",
                            "GLS350d X166",
                            4.4
                        ),
                        SecondRecyclerModel(
                            "https://media.fastestlaps.com/mercedes-benz-sl-500-r129.jpg",
                            "SL500 R129",
                            4.5
                        ),
                        SecondRecyclerModel(
                            "https://i.pinimg.com/originals/65/9e/c8/659ec8047abee475ef70af0d57511f60.jpg",
                            "E63 W213",
                            4.6
                        ),
                    )
                ),
                FirstRecyclerModel(
                    "Audi",
                    listOf(
                        SecondRecyclerModel(
                            "https://images.caradisiac.com/images/8/1/2/3/178123/S0-salon-de-francfort-2019-audi-devoile-la-nouvelle-rs6-600547.jpg",
                            "RS6 C8",
                            4.1
                        ),
                        SecondRecyclerModel(
                            "https://i.infocar.ua/i/2/1621/97305/1920x.jpg",
                            "Q5 8R",
                            4.2
                        ),
                        SecondRecyclerModel(
                            "https://www.auto-data.net/images/f27/audi-a8-d5.jpg",
                            "A8 D5",
                            4.3
                        ),
                        SecondRecyclerModel(
                            "https://www.largus.fr/images/images/ORPHEA_107829_1.jpg",
                            "A4 B8",
                            4.4
                        ),
                        SecondRecyclerModel(
                            "https://avatars.mds.yandex.net/get-verba/787013/2a0000016093933a1b00d0ee0d796123cbbd/cattouchret",
                            "R8 4S",
                            4.5
                        ),
                        SecondRecyclerModel(
                            "https://i.infocar.ua/i/2/5949/116264/1920x.jpg",
                            "Q7 4M",
                            4.6
                        ),
                    )
                ),
            )
        )
        binding.recyclerView.adapter = adapter1
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)

        //searchView.tint

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter1.filterByName(newText.orEmpty())
                return true
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}