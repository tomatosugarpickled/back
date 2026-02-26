const followWrapper = document.querySelector(".main-center")


let followPage = 1;
let followCriteria = {hasMore: true};
let followCheckScroll = true;

memberId = document.getElementById("member-id").value;

followService.getLists(memberId,followPage,followListLayout.showList)

followWrapper.addEventListener('scroll', async () => {
    if(!followCheckScroll || !followCriteria.hasMore) {
        return;
    }

    // 현재 스크롤 위치
    const scrollTop = followWrapper.scrollTop;     // 현재 스크롤 위치
    const clientHeight = followWrapper.clientHeight; // 눈에 보이는 높이
    const scrollHeight = followWrapper.scrollHeight; // 전체 스크롤 높이

    // 바닥에 닿았을 때
    if(scrollTop + clientHeight >= scrollHeight - 5) {
        followCheckScroll = false;
        const result = await followService.getLists(memberId,++followPage,followListLayout.showList);

        if(result){
            followCriteria.hasMore = result.hasMore;
        }
    }

    setTimeout(() => {
        followCheckScroll = true;
    }, 500)
})