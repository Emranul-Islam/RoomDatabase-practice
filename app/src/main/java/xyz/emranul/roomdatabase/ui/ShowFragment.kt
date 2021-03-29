package xyz.emranul.roomdatabase.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import xyz.emranul.roomdatabase.R
import xyz.emranul.roomdatabase.databinding.ShowFragmentBinding
import xyz.emranul.roomdatabase.model.Car
import xyz.emranul.roomdatabase.viewmodel.CarViewModel

class ShowFragment : Fragment() {

    private val TAG = "TAG"
    private  var _binding: ShowFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: CarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ShowFragmentBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this).get(CarViewModel::class.java)

        val car = Car(0,"CNG","Regular","Green")

//        viewModel.deleteAllCar()

//        viewModel.addCar(car)
//        Log.d(TAG, "onCreateView: Car Added")

        viewModel.getAllCar().observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "onCreateView: ${it.toString()}")
        })

     //   viewModel.updateCar(Car(4,"Bus","Big","Red"))

//        viewModel.deleteCar(Car(6,"","",""))


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}