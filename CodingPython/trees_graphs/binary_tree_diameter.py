'''
Binary Tree Exercise, find the diameter of a tree (number of nodes on
 the longest path between two leaves in the tree.
 https://www.hackerearth.com/practice/data-structures/trees/binary-and-nary-trees/tutorial/
'''
class TreeNode:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


def add_node(root, location, data):
    loc = root
    for i in range(0, len(location) - 1):
        s = location[i]
        if s == 'L':
            if loc.left is None:
                loc.left = TreeNode(0)

            loc = loc.left
        else:
            if loc.right is None:
                loc.right = TreeNode(0)

            loc = loc.right

    s = location[len(location) - 1]
    if s == 'L':
        if loc.left is None:
            loc.left = TreeNode(data)
        else:
            loc.left.data = data
    else:
        if loc.right is None:
            loc.right = TreeNode(data)
        else:
            loc.right.data = data


def diameter(root):
    h, d = diameter_helper(root)
    return d


def diameter_helper(root):
    if root is None:
        return (0, 0)
    else:
        hl, dl = diameter_helper(root.left)
        hr, dr = diameter_helper(root.right)

        h = max(hl, hr) + 1
        d = max(dl, dr, 1 + hl + hr)
        return h, d


if __name__ == '__main__':
    n, data = [int(x) for x in input().split(' ')]
    root = TreeNode(data)
    for i in range(0, n-1):
        location = input()
        data = input()
        add_node(root, location, data);

    diam = diameter(root)
    print(diam)
