package com.androidteam.sellingthing.sellingthing;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Tab1Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Tab1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab1Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;

    private FirebaseDatabase database;
    private DatabaseReference reference;
    private ProgressDialog progressDialog;


    private List<Product> productList = new ArrayList<>();
    int[] sampleImages = {R.drawable.electronic,R.drawable.fashion,R.drawable.sport,R.drawable.camera};



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Tab1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab1Fragment newInstance(String param1, String param2) {
        Tab1Fragment fragment = new Tab1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab1,container,false);



        recyclerView = view.findViewById(R.id.recycler_view);



        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,8,true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
        progressDialog = new ProgressDialog(getActivity());

        progressDialog.setMessage("Loading Data from Firebase Database");

        progressDialog.show();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference().child("Product");
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                productList.add(dataSnapshot.getValue(Product.class));

                productAdapter = new ProductAdapter(productList,getActivity());
                recyclerView.setAdapter(productAdapter);
                progressDialog.dismiss();
                productAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for(DataSnapshot dataSnapshot1 :  dataSnapshot.getChildren()){
//                    Product product = dataSnapshot1.getValue(Product.class);
//                    productList.add(product);
//
//                }
//                productAdapter = new ProductAdapter(productList,getActivity());
//                recyclerView.setAdapter(productAdapter);
//                progressDialog.dismiss();
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                progressDialog.dismiss();
//
//            }
//        });

        //insertItem();
        return view;
    }
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
//    public void insertItem(){
//
//        database = FirebaseDatabase.getInstance();
//        reference = database.getReference("Product");
//
//        Product product = new Product("Coca cola","popular dink ","5","$ 0.5","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5aa-4LErrHYE4jwpVr39dWEDDkpUSzVFMIubpVdRW8gHkJ1d1GA");
//        Product product1 = new Product("Coca cola","popular dink ","5","$ 0.5","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5aa-4LErrHYE4jwpVr39dWEDDkpUSzVFMIubpVdRW8gHkJ1d1GA");
//        Product product2 = new Product("Coca cola","popular dink ","5","$ 0.5","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5aa-4LErrHYE4jwpVr39dWEDDkpUSzVFMIubpVdRW8gHkJ1d1GA");
//        Product product3 = new Product("Coca cola","popular dink ","5","$ 0.5","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5aa-4LErrHYE4jwpVr39dWEDDkpUSzVFMIubpVdRW8gHkJ1d1GA");
//        Product product4 = new Product("Coca cola","popular dink ","5","$ 0.5","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5aa-4LErrHYE4jwpVr39dWEDDkpUSzVFMIubpVdRW8gHkJ1d1GA");
//        Product product5 = new Product("Coca cola","popular dink ","5","$ 0.5","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5aa-4LErrHYE4jwpVr39dWEDDkpUSzVFMIubpVdRW8gHkJ1d1GA");
//        Product product6 = new Product("Coca cola","popular dink ","5","$ 0.5","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5aa-4LErrHYE4jwpVr39dWEDDkpUSzVFMIubpVdRW8gHkJ1d1GA");
//        productList.add(product);
//        productList.add(product1);
//        productList.add(product2);
//        productList.add(product3);
//        productList.add(product4);
//        productList.add(product5);
//        productList.add(product6);
//
//        productAdapter.notifyDataSetChanged();
//
//    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
