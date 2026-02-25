const educationLayout = (() => {
    const showList = (data) => {
        const educationContainer = document.querySelector('.user-content-education-content-wrap');
        educationContainer.classList.add("user-content-history-content-wrap-ok")
        let text = ``;
        const educations = data.educations;

        if(memberId!==null && educations.length !== 0) {
            educations.forEach(education => {
                text += `
                    <div class="education-card">
                        <p class="education-title">${education.educationTitle || ''}</p>
                        
                        <div class="education-info">
                            <span class="education-badge">${education.educationType || ''}</span>
                            <span class="education-badge">${education.educationMajor || ''}</span>
                            <span class="education-badge">${education.educationGraduation || ''}</span>
                            <span class="education-period">${education.startDate || ''} ~ ${education.endDate || ''}</span>
                        </div>
                        
                        <div class="education-actions">
                            <a href="javascript:void(0)" 
                               data-id="${education.id}" 
                               class="education-delete-btn">삭제</a>
                        </div>
                    </div>`;
            })
            text += `
                <button type="button" class="education-button-wrap">
                    <span class="user-content-history-registration-word">등록하기</span>
                </button>
            `
        } else {
            educationContainer.classList.remove("user-content-history-content-wrap-ok")
            text += `
            <div class="user-content-education-content-wrap">
                <div class="user-content-education-content-div">
                    <p class="user-content-education-regi-word">학력을 등록하세요.</p>
                    <p class="user-content-education-etc-word">학교 뿐만 아니라 수료한 교육과정, 부트캠프 등도 입력할 수
                        있습니다.</p>
                </div>
                <button type="button" class="education-button-wrap">
                    <span class="user-content-history-registration-word">등록하기</span>
                </button>
                </div>`
        }

        educationContainer.innerHTML = text;
    }

    return {showList: showList};
})();