def solution(n):
    ans = 0
    if n == 0:
        return 1
    if n < 0:
        n *= -1
        ans = 2
    while n != 1:
        if n & 1:
            if n & 2 and n != 3:
                n += 1
            else:
                n -= 1
        else:
            n //= 2
        ans=ans+1
    return ans

print(solution('132488754789458797895498024730287408275902985727895435789243'))