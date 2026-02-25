const postService = (() => {

    const getLists = async (memberId,page, callback) => {
        page = page || 1;

        console.log("들어오!!");
        const response = await fetch(`/mypage/post/list/${memberId}/${page}`);
        const data = await response.json();
        if(callback){
            callback(data);
        }
    }
    return {getLists: getLists};
})();