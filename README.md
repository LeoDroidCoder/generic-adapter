

## Generic RecyclerView Adapter.

#### Lightweight library which simplifies creating RecyclerView adapters and illuminates writing boilerplate code.

Creating adapters is as easy as never before, just follow the steps below:

#### 1. Add dependency to your build.gradle (app-level).

    dependencies {
        implementation "com.leodroidcoder:generic-adapter:1.0.1"
    }

#### 2. Create a ViewHolder:

    public class UserViewHolder extends BaseViewHolder<User, OnRecyclerItemClickListener> {

        private TextView nameTv;

        public UserViewHolder(View itemView, OnRecyclerItemClickListener listener) {
            super(itemView, listener);
            // initialize view and set click listener
            nameTv = itemView.findViewById(R.id.tv_name);
            if (listener != null) {
                        itemView.setOnClickListener(v -> listener.onItemClick(getAdapterPosition()));
                    }
        }

        @Override
        public void onBind(User item) {
            // bind data to the views
            nameTv.setText(item.getName());
        }
    }

#### Or in Kotlin:

    class UserViewHolder(itemView: View, listener: OnRecyclerItemClickListener?) : BaseViewHolder<User, OnRecyclerItemClickListener>(itemView, listener) {

        private val nameTv: TextView? = itemView.tv_name

        init {
            listener?.run {
                itemView.setOnClickListener { onItemClick(adapterPosition) }
            }
        }

        override fun onBind(item: User) {
            nameTv?.text = item.name
        }
    }

#### 3. Create an Adapter:

    public class SimpleAdapter extends GenericRecyclerViewAdapter<User, OnRecyclerItemClickListener, UserViewHolder> {

        public SimpleAdapter(Context context, OnRecyclerItemClickListener listener) {
            super(context, listener);
        }

        @Override
        public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new UserViewHolder(inflate(R.layout.item_user, parent), getListener());
        }
    }

#### Or in Kotlin:

    class SimpleAdapter(context: Context, listener: OnRecyclerItemClickListener) : GenericRecyclerViewAdapter<User, OnRecyclerItemClickListener, UserViewHolder>(context, listener) {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
            return UserViewHolder(inflate(R.layout.item_user, parent), listener)
        }
    }

### That's   it!!

Just use it as a regular adapter in your Fragment or Activity:

    public class YourFragment extends Fragment implements OnRecyclerItemClickListener {

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            // ...
            // instantiate the adapter and set it onto a RecyclerView
            SimpleAdapter adapter = new SimpleAdapter(getActivity(), this);
            recyclerView.setAdapter(adapter);

            // populate adapter with data when it is ready
            List<User> users = getYourUsers();
            adapter.setItems(users);
        }

        /**
         * This is a callback of the recycler listener.
         * {@link OnRecyclerItemClickListener}.
         * Is being triggered when an item has been clicked.
         *
         * @param position clicked position
         */
        @Override
        public void onItemClick(int position) {
            // get the User entity, associated with the clicked item.
            final User clickedUser = adapter.getItem(position);
            // do whatever you want with it
        }
    }

#### Simplifies creating:
- Regular adapters
- Adapters with multiple ViewTypes
- with multiple listeners per item
- with DiffUtil

#### Checkout complete samples, including all these use cases.
#### Or read an article with the detailed explanation:
https://medium.com/@leo.droidcoder/recyclerview-adapter-a-piece-of-cake-with-the-generic-adapter-766cedffd81

### Enjoy!
