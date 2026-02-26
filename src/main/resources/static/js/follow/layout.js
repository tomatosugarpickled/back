const followListLayout = (() => {
    const showList = (data) => {
        const followContainer = document.querySelector('.follower');
        const followCount = document.querySelector(".follower-count");


        if(followCount){
            followCount.innerText = data.followerTotal;
        }

        const followers = data.follows;
        const criteria = data.criteria;

        let text = ``;




        text += `
            <div class="feed-card">
                                    <div class="feed-section">
                                        <div class="follower-list-header">
                                            <div class="follower-list-title">
                                                <p class="follower-title-text">팔로워 목록</p>
                                            </div>
                                        </div>
        `




        followers.forEach((follow) => {
            text += `
                <div class="follower-item">
                    <div class="follower-item-avatar">
                        <img src="https://i.pravatar.cc/150?img=33" alt="김에디">
                    </div>
                    <div class="follower-item-info">
                        <div class="follower-item-name">
                            <p class="follower-name">${follow.memberName}</p>
                        </div>
                        <div class="follower-item-job">
                            <p class="follower-job">브랜드 디자이너</p>
                        </div>
                        <div class="follower-item-period">
                            <p class="follower-period">2023년 05월 - 2023년 11월 · 6개월</p>
                        </div>
                    </div>
                    <button class="follower-item-follow-btn">팔로우</button>
                </div>
            `
        });

        text += `
                </div>
            </div>
        `
        if(criteria.page === 1) {
            followContainer.innerHTML = text;
        } else {
            followContainer.innerHTML += text;
        }

        return criteria

    }

    return {showList: showList};
})();