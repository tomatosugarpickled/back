const messageService = (() => {

//     추가
    const sendMessage = async (message) => {
        await fetch('/message/send', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(message)
        })
    }
    const selectMessageList = async (messageList) =>{
        await fetch('/message/list',{
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(messageList)
        })
    }

    return {sendMessage:sendMessage,
            selectMessageList:selectMessageList
    }
})();


