const myPageLayout = (() => {
    const showList = (data) => {
        const careerContainer = document.querySelector('.user-content-history-content-wrap');
        careerContainer.classList.add("user-content-history-content-wrap-career-ok")
        // careerContainer.classList.remove("user-content-history-content-wrap")
        let text = ``;
        const careers = data.careers;

        if(memberId!==null && careers.length !== 0) {
            careers.forEach(career => {
                text += `<div class="career-card">
                <span class="career-title">${career.affiliationTitle || ''}</span>
                
                <div class="career-info">
                    <span class="career-badge">${career.memberEmploymentType || ''}</span>
                    <span class="career-badge">${career.memberRole || ''}</span>
                    <span class="career-period">${career.startDate || ''} ~ ${career.endDate}</span>
                </div>
                
                <div class="career-actions">
                    <a href="javascript:void(0)" 
                       data-id="${career.id}" 
                       class="career-delete-btn">삭제</a>
                </div>
            </div>`;
            })
            text += `
            <button type="button" class="user-content-history-registration position-right">
                    <span class="user-content-history-registration-word">등록하기</span>
            </button>
        `
        } else {
            careerContainer.classList.remove("user-content-history-content-wrap-career-ok")
            text += `
            <div class="user-content-history-content-wrap">
                <div class="user-content-history-content-div-wrap">
                        <p class="user-content-history-content-first">경력을 등록하세요.</p>
                        <p class="user-content-history-content-second">경력 등록 시 다른 사용자에게 노출되고 새로운 제안을 받을
                            확률이 2배까지 증가합니다.</p>
                </div>
    
                <button type="button" class="user-content-history-registration">
                    <span class="user-content-history-registration-word">등록하기</span>
                </button>
            </div>
            `
        }

        careerContainer.innerHTML = text;
    }

    return {showList: showList};
})();