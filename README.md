Generic RecyclerView adapter

Are your tired of friting a lot of boilerplate code when creating RecyclerView adapter?
Create the generic one and each adapter will be as simple as:

public class UsersAdapter extends GenericRecyclerAdapter<User, OnRecyclerObjectClickListener<User>, UserViewHolder> {   
    public UsersAdapter(Context context) {
        super(context);
    }
    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserViewHolder(inflate(R.layout.item_user, parent));
    }
}

Here you will find a comple code of GenericRecyclerAdapter and a sample of it's implementation.

Step-by-step explanation you can find in my article:
https://medium.com/@leonidustenko/generic-recyclerview-adapter-a69a24ec25bc 
