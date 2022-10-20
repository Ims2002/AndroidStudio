package com.yaroslav.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FragmentDetalle extends Fragment {
    public static final String NAME_CONTACT = "com.yaroslav.fragment.NAME_CONTACT";
    public static final String SURNAME1_CONTACT = "com.yaroslav.fragment.SURNAME1_CONTACT";
    public static final String SURNAME2_CONTACT = "com.yaroslav.fragment.SURNAME2_CONTACT";
    public static final String BIRTH_CONTACT = "com.yaroslav.fragment.BIRTH_CONTACT";
    public static final String COMPANY_CONTACT = "com.yaroslav.fragment.COMPANY_CONTACT";
    public static final String EMAIL_CONTACT = "com.yaroslav.fragment.EMAIL_CONTACT";
    public static final String PHONE1_CONTACT = "com.yaroslav.fragment.PHONE1_CONTACT";
    public static final String PHONE2_CONTACT = "com.yaroslav.fragment.PHONE2_CONTACT";
    public static final String ADDRESS_CONTACT = "com.yaroslav.fragment.ADDRESS_CONTACT";
    public static final String CONTACT_CONTACT = "com.yaroslav.fragment.EXTRA_CONTACT";


    private Contact contact;

    public int id;
    private TextView tvName;
    private TextView tvFirstSurname;
    private TextView tvSecondSurname;
    private TextView tvBirth;
    private TextView tvCompany;
    private TextView tvEmail;
    private TextView tvPhone1;
    private TextView tvPhone2;
    private TextView tvAddress;
    private String nameContact;
    private String surname1Contact;
    private String surname2Contact;
    private String birthContact;
    private String companyContact;
    private String emailContact;
    private String phone1Contact;
    private String phone2Contact;
    private String addressContact;


    public FragmentDetalle() {
        super(R.layout.fragment_detail);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;

        contact = (Contact) getArguments().getSerializable(CONTACT_CONTACT);
/*
        nameContact = getArguments().getString(NAME_CONTACT);
        surname1Contact = getArguments().getString(SURNAME1_CONTACT);
        surname2Contact = getArguments().getString(SURNAME2_CONTACT);
        birthContact = getArguments().getString(BIRTH_CONTACT);
        companyContact = getArguments().getString(COMPANY_CONTACT);
        emailContact = getArguments().getString(EMAIL_CONTACT);
        phone1Contact = getArguments().getString(PHONE1_CONTACT);
        phone2Contact = getArguments().getString(PHONE2_CONTACT);
        addressContact = getArguments().getString(ADDRESS_CONTACT);*/
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvName = view.findViewById(R.id.tvName);
        tvFirstSurname = view.findViewById(R.id.tvSurname1);
        tvSecondSurname = view.findViewById(R.id.tvSurname2);
        tvBirth = view.findViewById(R.id.tvBirth);
        tvCompany = view.findViewById(R.id.tvCompany);
        tvEmail = view.findViewById(R.id.tvEmail);
        tvPhone1 = view.findViewById(R.id.tvPhone1);
        tvPhone2 = view.findViewById(R.id.tvPhone2);
        tvAddress = view.findViewById(R.id.tvAdress);

        /*contact = new Contact(id,nameContact,surname1Contact,surname2Contact,birthContact,companyContact
        ,emailContact,phone1Contact,phone2Contact,addressContact);*/

        showDetail(contact);
    }

    public void showDetail(Contact c) {
        tvName.setText(c.getName());
        tvFirstSurname.setText(c.getSurname1());
        tvSecondSurname.setText(c.getSurname2());
        tvBirth.setText(c.getBirth());
        tvCompany.setText(c.getBirth());
        tvEmail.setText(c.getEmail());
        tvPhone1.setText(c.getPhone1());
        tvPhone2.setText(c.getPhone2());
        tvAddress.setText(c.getAdress());
    }
}
