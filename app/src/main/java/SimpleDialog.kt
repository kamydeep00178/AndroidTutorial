import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.fragment.R
import kotlinx.android.synthetic.main.fragment_simple_dialog.view.*

class SimpleDialog : DialogFragment() {
    companion object {

        const val TAG = "SimpleDialog"

        private const val KEY_TITLE = "KEY_TITLE"
        private const val KEY_SUBTITLE = "KEY_SUBTITLE"



        fun newInstance(title: String, subTitle: String): SimpleDialog {
            val args = Bundle()
            args.putString(KEY_TITLE, title)
            args.putString(KEY_SUBTITLE, subTitle)
            val fragment = SimpleDialog()
            fragment.arguments = args
            return fragment
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_simple_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
        setupClickListeners(view)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    private fun setupView(view: View) {
        view.tvTitle.text = arguments?.getString(KEY_TITLE)
        view.tvSubTitle.text = arguments?.getString(KEY_SUBTITLE)
    }

    private fun setupClickListeners(view: View) {
        view.btnPositive.setOnClickListener {
            // TODO: Do some task here
            dismiss()
        }
        view.btnNegative.setOnClickListener {
            // TODO: Do some task here
            dismiss()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Hello! I am Alert Dialog")
                .setPositiveButton("Cool",
                    DialogInterface.OnClickListener { dialog, id ->

                        Log.e(TAG, "onCreateDialog: pos", )
                        dialog.dismiss()
                    })
                .setNegativeButton(R.string.cancel,
                    DialogInterface.OnClickListener { dialog, id ->

                        Log.e(TAG, "onCreateDialog: neg", )
                        dialog.cancel()

                    })
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("TAG", "onDestroy: ", )
    }

//    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        val builder = context?.let { AlertDialog.Builder(it) }
//        builder?.setTitle("Alert Dialog")
//        builder?.setMessage("Hello! I am Alert Dialog")
//        builder?.setPositiveButton("Cool", object: DialogInterface.OnClickListener {
//            override fun onClick(dialog:DialogInterface, which:Int) {
//                dismiss()
//            }
//        })
//        builder?.setNegativeButton("Cancel", object: DialogInterface.OnClickListener {
//            override fun onClick(dialog:DialogInterface, which:Int) {
//                dismiss()
//            }
//        })
//        return builder?.create()
//    }
}