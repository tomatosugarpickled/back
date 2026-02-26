const activityLayout = (() => {
   const showList = (data) => {
       console.log("전달받은 데이터 전체 : ",data)
       const activityContainer = document.querySelector('.user-content-activity-content-wrap');
       activityContainer.classList.add("user-content-history-content-wrap-ok")
       let text = ``;
       const activities = data;


       if(memberId!==null && activities.length !== 0) {
           activities.forEach(activity => {
               text +=  `
                    <div class="activity-card">
                        <p class="activity-title">${activity.awardTitle || ''}</p>
                        
                        <div class="activity-info">
                            <span class="activity-badge">${activity.activityType || ''}</span>
                            <span class="activity-date">${activity.startDate || ''}</span>
                        </div>
                        
                        ${activity.activityFiles && activity.activityFiles.length > 0 ? `
                            <div class="activity-images">
                                ${activity.activityFiles.map(file => { 
                                    const displayUrl = `/api/files/display?filePath=${encodeURIComponent(file.filePath)}&fileName=${encodeURIComponent(file.fileName)}`;
                                 return   `
                                    <img src="${displayUrl}" id="${file.id}" alt="${file.fileOriginalName}" class="activity-image">
                                `}).join('')}
                            </div>
                        ` : ''}
                        
                        <div class="activity-actions">
                            <a href="javascript:void(0)" 
                               data-id="${activity.id}" 
                               class="activity-delete-btn">삭제</a>
                        </div>
                    </div>
                    `;
           })
           text += `
                        <button type="button" class="activity-button">
                            <span class="user-content-history-registration-word">등록하기</span>
                        </button>
                    `
       } else {
           activityContainer.classList.remove("user-content-history-content-wrap-ok")
           text += `
                <div class="user-content-activity-content-wrap">
                    <div class="user-content-activity-content-inner">
                        <div class="user-content-activity-div">
                            <p class="activity-word-first">커리어를 위해 진행한 모든 활동을 등록하세요.</p>
                            <p class="user-content-activity">참가, 수상, 자격증, 프로젝트, 논문, 저서, 뉴스, 특허, 인터뷰, 투자
                                등 자신을 어필할 수 있는 활동을 등록하세요.</p>
                        </div>
                        <button type="button" class="activity-button">
                            <span class="user-content-history-registration-word">등록하기</span>
                        </button>
                    </div>
                </div>
                `
       }

       activityContainer.innerHTML = text;
   }

   return {showList: showList};
})();