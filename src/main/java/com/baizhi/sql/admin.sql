select * from d_admin;
select admin_id,username, password from d_admin where username='hhy';
select * from d_category;
select d.category_id,d.name dname,p.name pname,d.levels from d_category d left join d_category p on d.parent_id=p.category_id

  select book_id bookId ,name ,author,cover,press,press_date pressDate ,edition ,
       print_date printDate,impression ,isbn,word_num wordNum,page_num pageNum ,sizes ,paper ,
       pack ,price ,dprice ,create_date createDate,editor_recomment editorRecomment,content_abstract contentAbstract,
       author_abstract authorAbstract,director ,media_commentary mediaCommentary,ale,stock,category_id categoryId from d_book
       
    select book_id bookId ,name ,author,cover,press,press_date pressDate ,edition ,
       print_date printDate,impression ,isbn,word_num wordNum,page_num pageNum ,sizes,paper ,
       pack ,price ,dprice ,create_date createDate,editor_recomment editorRecomment,content_abstract contentAbstract,
       author_abstract authorAbstract,director ,media_commentary mediaCommentary,ale,stock from d_book where name='西游记'
       
       select category_id categoryId,name,parent_id parentId,levels from d_category where levels='2'
       
        select book_id bookId ,name ,author,cover,press,press_date pressDate ,edition ,
       print_date printDate,impression ,isbn,word_num wordNum,page_num pageNum ,sizes,paper ,
       pack ,price ,dprice ,create_date createDate,editor_recomment editorRecomment,content_abstract contentAbstract,
       author_abstract authorAbstract,director ,media_commentary mediaCommentary,ale,stock,category_id categoryId from d_book 
       
      select d.category_id dcategory_id,d.name dname, d.parent_id dparent_id,d.levels dlevels,
      b.book_id bbook_id,b.name bname,b.author bauthor,b.cover bcover,b.press bpress,b.press_date bpressDate,b.edition bediton,b.print_date bprint_date,b.impression bimpression,
      b.isbn bisbn,b.word_num bword_num,b.page_num bpage_num,b.sizes bsizes,b.paper bpaper,b.pack bpack,b.price price,b.dprice dprice,b.create_date bcreate_date,
      b.editor_recomment beditor_recomment,b.content_abstract bcontent_abstract,b.author_abstract bauthor_abstract,b.director bdirector,b.media_commentary bmedia_commentary,
      b.ale bale,b.stock bstock,b.category_id bcategory_id
      from d_category d left join d_book b on d.category_id =b.category_id  
      
      select i.item_id iid,i.count icount,b.book_id bid,b.name bname,b.price bprice,b.dprice bdprice from d_item i left join d_book b on i.book_id=b.book_id 
       select i.item_id iid,i.count icount,b.book_id bid,b.name bname, b.cover cover,b.price bprice,b.dprice bdprice from d_item i left join d_book b on i.book_id=b.book_id