package alisha.digipodium.implicit_intent_02;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class ThirdFragment extends Fragment {

    private Button btnAddContact;
    private EditText phone,email,txtSecondName,txtFirstName;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnAddContact=view.findViewById(R.id.btnAddContact);
        txtFirstName = view.findViewById(R.id.txtFirstName);
        txtSecondName = view.findViewById(R.id.txtSecondName);
        phone =view.findViewById(R.id.phone);
        email = view.findViewById(R.id.email);
        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                intent.putExtra(ContactsContract.Intents.Insert.EMAIL,email.getText())
                        .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE,ContactsContract.CommonDataKinds.Email.TYPE_WORK)
                        .putExtra(ContactsContract.Intents.Insert.PHONE,phone.getText())
                        .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                        .putExtra(ContactsContract.Intents.Insert.NAME,txtFirstName.getText() + " " +txtSecondName.getText());
                startActivity(intent);
            }
        });
    }
}