const followService = (() => {

    const getLists = async (memberId, page ,callback) => {
        page = page || 1;
        const response = await fetch(`/mypage/follow/list/${memberId}/${page}`);
        const data = await response.json();
        if(callback){
            callback(data);
        }
    }

    return {getLists: getLists};
})();
