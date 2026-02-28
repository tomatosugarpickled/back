const profileLayout = (() => {
    const showProfile = (profile) => {
        const profileWrap = document.getElementById("user-profile-wrap");
        const profileImg = document.querySelector(".park-in");


        let image = ``;
        let text = ``;

        // 2. 서버에서 넘어온 Optional 알맹이(MemberFileDTO) 해체
        // profile 객체 안에 있는 필드명을 정확히 써야 합니다! (예: filePath, fileName)

        if(profile && profile.filePath && profile.fileName){
            const { filePath, fileName } = profile;


        // 3. FileController의 display 메서드를 호출하는 URL 생성
        // 쿼리 스트링(?filePath=...&fileName=...) 형식으로 보내야 합니다.
        const displayUrl = `/api/files/display?filePath=${filePath}&fileName=${fileName}`;

            image = `<img src="${displayUrl}" alt="profile-img" class="park-img">`

            text = `
                <div class="user-profile-wrap">
                    <div class="user-profile-img-wrap">
                        <img src="${displayUrl}" alt="profile-img" class="pro-img">
                    </div>
                </div>
            `
            profileWrap.innerHTML = text;
            profileImg.innerHTML = image;
        }


        else{
            text = `
                <div class="user-profile-wrap">
                    <div class="user-profile-img-wrap">
                        <input type="file" class="profile-file" id="owner-profile-input">
                        <img src="/image/profiles/basicprofile.jpg" alt="profile-img" class="pro-img">
                    </div>
                </div>
            `
            image = `<img src="/image/profiles/basicprofile.jpg" alt="profile-img" class="park-img">`

            profileWrap.innerHTML = text;
            profileImg.innerHTML = image;
        }

    }


    return {showProfile: showProfile};
})();