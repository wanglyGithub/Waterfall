# Waterfall
Use RecyclerView to achieve the waterfall flow operation


android.support.v7.widget.RecyclerView 可知 RecyclerView 在 v7 包下！相应的下载就不在这里赘述了，可以使用Studio 直接引用！
可见Gradle 功能的强大！

简单的介绍：

      RecyclerView 与 ListView 一样，在加载数据的时候以列表的形式加载！Android L 在 V7包中引入了RecyclerView 这个控件！
      
      1、它可以很方便的使我们的数据展示以列表的形式进行展现，同样也可以使用快速的修改为横向的ListView，GridView，由此，可见这个
         东西的实用性！
      2、方便，具体可以看代码在这里就简单的列出Adapter 中的事例代码：
        @Override
        public StaggeredAdapter.MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.from(mContext).inflate(R.layout.list_item, null);
            MyViewHodler viewHodler = new MyViewHodler(view);
            return viewHodler;
        }

        @Override
        public void onBindViewHolder(StaggeredAdapter.MyViewHodler holder, int position) {
            holder.tv_info.setText(mDatas.get(position));
            ImageLoader.getInstance().displayImage(Constants.images[position], holder.iv_pic, options); //

        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }
      还记得我们通常自己定义Adapter 适配器的时候 都是 extends BaseAdapter 重写那么多方法，还需要自己 定义ViewHolder，在这里我们就可以
      完成ViewHoder 的绑定！
      
      3、便于封装！不在声明了！需要注意的是 间距的控制，我们可以使用 以下函数：
      
       //recycleView.addItemDecoration(decoration);
      
      我们主要是 将其 快速的实现 瀑布流效果！而不再沿用一些的开源库！而是直接使用 RecyclerView
   

RecyclerView 的基本使用：

1、findViewById 找到 RecyclerView

2、设置 Adapter 

3、设置布局管理器 以下三种的设置形式！
  （1）StaggeredGridLayoutManager
  （2）LinearLayoutManager
  （3）GridLayoutManager
  
  
  实现效果图：
  
  
  
  
  
  


