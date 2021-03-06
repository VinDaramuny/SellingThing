package com.androidteam.sellingthing.sellingthing;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
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
public class ExploreTabFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;

    private List<Product> productList = new ArrayList<>();
    int[] sampleImages = {R.drawable.electronic,R.drawable.fashion,R.drawable.sport,R.drawable.camera};



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ExploreTabFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment Tab1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExploreTabFragment newInstance() {
        ExploreTabFragment fragment = new ExploreTabFragment();
        Bundle args = new Bundle();
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
        View view = inflater.inflate(R.layout.fragment_explore_tab,container,false);
        recyclerView = view.findViewById(R.id.recycler_view);
        productList = (List<Product>) getArguments().getSerializable("Products");
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,8,true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(productList,getActivity());
        recyclerView.setAdapter(productAdapter);


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
