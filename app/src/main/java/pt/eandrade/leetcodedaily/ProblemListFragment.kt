package pt.eandrade.leetcodedaily

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import pt.eandrade.leetcodedaily.databinding.FragmentProblemListBinding
import pt.eandrade.leetcodedaily.misc.IsProblem
import pt.eandrade.leetcodedaily.problems.*

@Suppress("NO_REFLECTION_IN_CLASS_PATH")
class ProblemListFragment : Fragment() {
    private var _binding: FragmentProblemListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProblemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val problems = listOf(
            TwoSum::class.java,
            ValidParenthesis::class.java,
            MergeTwoLists::class.java,
            BestTimeBuyStock::class.java,
            IsPalindrome::class.java,
            InvertBinaryTree::class.java,
            ValidAnagram::class.java,
            BinarySearch::class.java,
            FloodFill::class.java,
            MaximumSubarray::class.java,
            LowestCommonAncestorBinarySearchTree::class.java,

        )

        for(prob in problems){
            val button = Button(requireContext())
            button.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            button.text = prob.simpleName

            val cls = Class.forName(prob.name).kotlin
            val ctor = cls.constructors.first()
            val obj = ctor.call() as IsProblem

            button.setOnClickListener {
                val directions = ProblemListFragmentDirections
                    .actionProblemListFragmentToProblemSolvingFragment(obj)
                findNavController().navigate(directions)
            }
            binding.linearLayoutProblemList.addView(button)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}