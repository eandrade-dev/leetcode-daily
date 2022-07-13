package pt.eandrade.leetcodedaily

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import pt.eandrade.leetcodedaily.databinding.FragmentProblemSolvingBinding
import pt.eandrade.leetcodedaily.problems.*

class ProblemSolvingFragment : Fragment() {
    private var _binding: FragmentProblemSolvingBinding? = null
    private val binding get() = _binding!!

    private val args: ProblemSolvingFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProblemSolvingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textViewProblemName.text = args.problemClass

        binding.buttonRunProblem.setOnClickListener {
            runProblem()
        }
        binding.buttonBack.setOnClickListener {
            findNavController().popBackStack()
        }

        runProblem()
    }

    private fun runProblem(){
        if(args.problemClass == TwoSum::class.java.name){
            binding.textViewResult.text = TwoSum().run()
        }

        if(args.problemClass == ValidParenthesis::class.java.name){
            binding.textViewResult.text = ValidParenthesis().run()
        }

        if(args.problemClass == MergeTwoLists::class.java.name){
            binding.textViewResult.text = MergeTwoLists().run()
        }

        if(args.problemClass == BestTimeBuyStock::class.java.name){
            binding.textViewResult.text = BestTimeBuyStock().run()
        }

        if(args.problemClass == IsPalindrome::class.java.name){
            binding.textViewResult.text = IsPalindrome().run()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}