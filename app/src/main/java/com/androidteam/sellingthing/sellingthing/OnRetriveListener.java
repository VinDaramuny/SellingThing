package com.androidteam.sellingthing.sellingthing;

import java.util.List;

public interface OnRetriveListener {
    void OnRetriveStart();
    void OnRetriveSuccess(List<Product> products);
}
