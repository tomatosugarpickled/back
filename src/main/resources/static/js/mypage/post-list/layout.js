const postListLayout = (() => {
    console.log("postLayout실행");
    const showList = (data) => {
        const postContainer = document.querySelector('.feed-wrapper');

        const posts = data.posts;
        const criteria = data.criteria;

        console.log("posts",posts.length);
        console.log("criteria",criteria);
        console.log(postContainer);

        let text = ``;

        posts.forEach((post) => {
            text += `
                <div class="feed-card">
                    <div class="feed-section">
                        <div class="feed-header">
                            <div class="fead-profile">
                                <div class="feed-profile-container">
                                    <div class="feed-profile-wrapper">
                                        <img src="/image/profiles/basicprofile.jpg" alt="profile-img" class="pro-img">
                                    </div>
                                </div>
                            </div>
                            <div class="feed-header-info">
                                <div class="feed-header-info-wrapper">
                                    <div class="feed-header-info-name-section">
                                        <div class="feed-header-info-name-wrapper">
                                            <div class="feed-header-info-name">
                                                <p class="name-tag">${post.memberName}</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="feed-header-info-date-section">
                                        <p class="feed-user-post-time">${post.createdDatetime}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="feed-content-container">
                            <div class="feed-content-wrapper">
                                <div class="feed-content-text-section">
                                    <div class="feed-content-text-wrapper">
                                        <span>${post.postContent}</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            `
        });
        if(criteria.page === 1) {
            postContainer.innerHTML = text;
        } else {
            postContainer.innerHTML += text;
        }

        return criteria
    }
    return {showList: showList};
})();