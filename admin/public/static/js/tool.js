Tool = {
    /**
     * 空校验 null或""都返回true
     */
    isEmpty: function (obj) {
        if ((typeof obj == 'string')) {
            return !obj || obj.replace(/\s+/g, "") == ""
        } else {
            return (!obj || JSON.stringify(obj) === "{}" || obj.length === 0);
        }
    },

    /**
     * 非空校验
     */
    isNotEmpty: function (obj) {
        return !this.isEmpty();
    },

    /**
     * 长度校验
     */
    isLength: function (str, min, max) {
        return $.trim(str).length >= min && $.trim(str).length <= max;
    },

    /**
     * 移除对象数组中的对象
     * @param array
     * @param obj
     * @returns {number}
     */
    removeObj: function (array, obj) {
        let index = -1;
        for (let i = 0; i < array.length; i++) {
            if (array[i] === obj) {
                array.splice(i, 1);
                index = i;
                break;
            }
        }
        return index;
    }
};