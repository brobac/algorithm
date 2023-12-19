s = set()

n = int(input())
initial = set([i for i in range(1, 21)])
for i in range(n):
    v = input()

    if v.startswith("add"):
        _, num = v.split()
        s.add(int(num))
    elif v.startswith("remove"):
        _, num = v.split()
        s.discard(int(num))
    elif v.startswith("check"):
        _, num = v.split()
        if int(num) in s:
            print(1)
        else:
            print(0)
    elif v.startswith("toggle"):
        _, num = v.split()
        num = int(num)
        if num in s:
            s.remove(num)
        else:
            s.add(num)
    elif v.startswith("all"):
        s = initial
    else:
        s = set()
