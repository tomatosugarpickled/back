const postWrapper = document.querySelector('.center');



let page = 1;
let criteria = {hasMore: true};
let checkScroll = true;

memberId = document.getElementById("member-id").value;


postService.getLists(memberId,page,postListLayout.showList)

postWrapper.addEventListener('scroll', async () => {
    if(!checkScroll || !criteria.hasMore) {
        return;
    }

    // 현재 스크롤 위치
    const scrollTop = postWrapper.scrollTop;     // 현재 스크롤 위치
    const clientHeight = postWrapper.clientHeight; // 눈에 보이는 높이
    const scrollHeight = postWrapper.scrollHeight; // 전체 스크롤 높이

    // 바닥에 닿았을 때
    if(scrollTop + clientHeight >= scrollHeight - 5) {
        checkScroll = false;
        const result = await postService.getLists(memberId,++page,postListLayout.showList);

        if(result){
            criteria.hasMore = result.hasMore;
        }
    }

    setTimeout(() => {
        checkScroll = true;
    }, 500)
})