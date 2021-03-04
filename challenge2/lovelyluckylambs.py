


def fibonacci(lambs):
    total = 0
    prev = 0
    cur = 1
    ans = 0
    while (total+cur) <= lambs:
        total += cur
        ans += 1
        temp = prev
        prev = cur
        cur += temp
        # print(f"prev: {prev} cur: {cur}")
    return ans 

def factorial(lambs):
    total = 0  
    cur = 1
    ans = 0
    while total + cur <= lambs:
        total += cur
        cur *= 2
        ans += 1
        # print(f"cur: {cur} total: {total}")
    # print(f"factorial produced {ans} nums ending in {cur}")
    return ans


def solution(total_lambs):
    return fibonacci(total_lambs) - factorial(total_lambs)

print(solution(1e9))

