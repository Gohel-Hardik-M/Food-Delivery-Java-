package com.tss.Services;

import com.tss.Cart.Cart;
import com.tss.DB.DB;
import com.tss.Menu.Menu;

public class CartService {


        private DB db;
        private Cart cart;


        public CartService(DB db, Cart cart) {
            this.db = db;
            this.cart = cart;
        }


}
