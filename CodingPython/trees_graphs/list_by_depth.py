# Cracking the Code problem 4.4, build linked lists by depth


class TreeNode:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


def get_lists_by_depth(root):
    lists = []
    if root is None:
        return lists

    build_lists_by_depth(root, 0, lists)
    return lists


def build_lists_by_depth(node, level, lists):
    if node is None:
        return
    else:
        list = None
        if level == len(lists):
            list = []
            lists.append(list)
        else:
            list = lists[level]

        list.append(node.data)
        build_lists_by_depth(node.left, level + 1, lists)
        build_lists_by_depth(node.right, level+1, lists)


root = TreeNode(0)
root.left = TreeNode(1)
root.right = TreeNode(2)
root.left.left = TreeNode(3)
root.right.right = TreeNode(4)
root.left.left.left = TreeNode(5)

lists = get_lists_by_depth(root)

print(lists)
