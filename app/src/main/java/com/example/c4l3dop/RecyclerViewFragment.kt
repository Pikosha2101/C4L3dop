package com.example.c4l3dop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.c4l3dop.adapters.FirstRecyclerAdapter
import com.example.c4l3dop.databinding.RecyclerViewFragmentBinding
import com.example.c4l3dop.models.FirstRecyclerModel
import com.example.c4l3dop.models.SecondRecyclerModel

class RecyclerViewFragment : Fragment(R.layout.recycler_view_fragment) {
    private var _binding : RecyclerViewFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        _binding = RecyclerViewFragmentBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adapter1 = FirstRecyclerAdapter(
            //не открывать тут ад
            listOf(
                FirstRecyclerModel(
                    "Проверка1",
                    listOf(
                       SecondRecyclerModel(
                           R.drawable.baseline_arrow_forward_24,
                           "test11",
                           4.1
                       ),
                        SecondRecyclerModel(
                            R.drawable.baseline_arrow_forward_24,
                            "test12",
                            4.2
                        ),
                        SecondRecyclerModel(
                            R.drawable.baseline_arrow_forward_24,
                            "test13",
                            4.3
                        ),
                        SecondRecyclerModel(
                            R.drawable.baseline_arrow_forward_24,
                            "test14",
                            4.4
                        ),
                        SecondRecyclerModel(
                            R.drawable.baseline_arrow_forward_24,
                            "test15",
                            4.5
                        ),
                        SecondRecyclerModel(
                            R.drawable.baseline_arrow_forward_24,
                            "test16",
                            4.6
                        ),
                    )
                ),
                FirstRecyclerModel(
                    "Проверка2",
                    listOf(
                        SecondRecyclerModel(
                            R.drawable.baseline_arrow_forward_24,
                            "test21",
                            4.1
                        ),
                        SecondRecyclerModel(
                            R.drawable.baseline_arrow_forward_24,
                            "test22",
                            4.2
                        ),
                        SecondRecyclerModel(
                            R.drawable.baseline_arrow_forward_24,
                            "test23",
                            4.3
                        ),
                        SecondRecyclerModel(
                            R.drawable.baseline_arrow_forward_24,
                            "test24",
                            4.4
                        ),
                        SecondRecyclerModel(
                            R.drawable.baseline_arrow_forward_24,
                            "test25",
                            4.5
                        ),
                        SecondRecyclerModel(
                            R.drawable.baseline_arrow_forward_24,
                            "test26",
                            4.6
                        ),
                    )
                ),
                FirstRecyclerModel(
                    "Проверка3",
                    listOf(
                        SecondRecyclerModel(
                            R.drawable.baseline_arrow_forward_24,
                            "test31",
                            4.1
                        ),
                        SecondRecyclerModel(
                            R.drawable.baseline_arrow_forward_24,
                            "test32",
                            4.2
                        ),
                        SecondRecyclerModel(
                            R.drawable.baseline_arrow_forward_24,
                            "test33",
                            4.3
                        ),
                        SecondRecyclerModel(
                            R.drawable.baseline_arrow_forward_24,
                            "test34",
                            4.4
                        ),
                        SecondRecyclerModel(
                            R.drawable.baseline_arrow_forward_24,
                            "test35",
                            4.5
                        ),
                        SecondRecyclerModel(
                            R.drawable.baseline_arrow_forward_24,
                            "test36",
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

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}